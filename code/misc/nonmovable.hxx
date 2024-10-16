#pragma once

class Nonmovable {
 protected:
  Nonmovable() noexcept = default;
  ~Nonmovable() noexcept = default;

 public:
  Nonmovable(Nonmovable&&) = delete;
  auto operator=(Nonmovable&&) -> Nonmovable& = delete;
};