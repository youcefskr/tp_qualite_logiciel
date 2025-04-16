
# TP1 - Tests JUnit & Couverture de Code
## ✅ Exercice 1 - Palindrome
- ❌ **Bug détecté** : les indices `i++` et `j--` étaient inversés (`i--`, `j++`).


---

## ✅ Exercice 2 - Anagram
- ❌ **Bug détecté** : boucle `for` avec `i <= s1.length()` provoque `IndexOutOfBoundsException`.

---

## ✅ Exercice 3 - BinarySearch
- ❌ **Bug détecté** : la boucle `while (low < high)` empêche de tester l'élément `mid` quand `low == high`.


---

## ✅ Exercice 4 - QuadraticEquation
- ✅ **Pas de bug** identifié.

## ✅ Exercice 5 - RomanNumeral
- ❌ Bug détecté : boucle `for (int i = 0; i <= symbols.length)` causait une exception `IndexOutOfBoundsException`.
- ✅ Couverture : tests sur les cas limites (1, 4, 9, 40, 90, 3999, etc.).

## ✅ Exo6 - FizzBuzz
-  Correction apportée : la condition `if (n <= 1)` devait être `if (n < 1)` pour permettre `fizzBuzz(1)`.  



