#pragma once

#include <type_traits>
#include <vector>

template <typename Iter>
using select_access_type_for = std::conditional_t<
    std::is_same_v<Iter, std::vector<bool>::iterator> ||
        std::is_same_v<Iter, std::vector<bool>::const_iterator>,
    typename Iter::value_type, typename Iter::reference>;

template <typename Iter1, typename Iter2> class ZipIterator {
public:
  using value_type =
      std::pair<select_access_type_for<Iter1>, select_access_type_for<Iter2>>;

  ZipIterator() = delete;

  ZipIterator(Iter1 iter_1_begin, Iter2 iter_2_begin)
      : m_iter_1_begin{iter_1_begin}, m_iter_2_begin{iter_2_begin} {}

  auto operator++() -> ZipIterator & {
    ++m_iter_1_begin;
    ++m_iter_2_begin;
    return *this;
  }

  auto operator++(int) -> ZipIterator {
    auto tmp = *this;
    ++*this;
    return tmp;
  }

  auto operator!=(const ZipIterator &other) const { return !(*this == other); }

  auto operator==(const ZipIterator &other) const {
    return m_iter_1_begin == other.m_iter_1_begin ||
           m_iter_2_begin == other.m_iter_2_begin;
  }

  auto operator*() -> value_type {
    return value_type{*m_iter_1_begin, *m_iter_2_begin};
  }

private:
  Iter1 m_iter_1_begin;
  Iter2 m_iter_2_begin;
};

template <typename T>
using select_iterator_for =
    std::conditional_t<std::is_const_v<std::remove_reference_t<T>>,
                       typename std::decay_t<T>::const_iterator,
                       typename std::decay_t<T>::iterator>;

template <typename T, typename U> class Zipper {
public:
  using Iter1 = select_iterator_for<T>;
  using Iter2 = select_iterator_for<U>;

  using ZipIter = ZipIterator<Iter1, Iter2>;

  template <typename V, typename W> Zipper(V &&a, W &&b) : m_a{a}, m_b{b} {}

  auto begin() -> ZipIter { return ZipIter{std::begin(m_a), std::begin(m_b)}; }

  auto end() -> ZipIter { return ZipIter{std::end(m_a), std::end(m_b)}; }

private:
  T m_a;
  U m_b;
};

template <typename T, typename U> auto zip(T &&t, U &&u) {
  return Zipper<T, U>{std::forward<T>(t), std::forward<U>(u)};
}