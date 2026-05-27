q = int(input())

def fun(b: str, g: str, n: int) -> str:
    actual = list(b)

    for i in range(n):
        to_match = g[i]

        if actual[i] == to_match:
            continue

        j = i
        while j < n and actual[j] != to_match:
            j+=1

        if j == n:
            return "NO"

        actual[i], actual[j] = actual[j], actual[i]

    return "YES"

for _ in range(q):
    n = int(input())
    b,g = input().split()

    print(fun(b, g, n))
