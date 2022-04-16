# Kotlin Native Quest mod Proof of Concept 

TODO: 

- [ ] il2cpp_utils:
  - [ ] Kotlin Native implementation similar to quest-hooks-rs
  - [ ] Bindings to bs-hooks (can C++ bindings work?)
- [ ] hooking:
  - [ ] Wait for flamingo and use those bindings? Kotlin can generate bindings from C headers
  - [ ] Somehow figure out hooks on Kotlin
- [ ] exception handling:
  - [ ] Kotlin's exceptions need to be logged properly
  - [ ] IL2CPP catch handling
- [ ] logging:
  - [x] ADB logcat works out of the box
  - [ ] make paperlog bindings?
- [ ] custom-types/codegen/questui bindings