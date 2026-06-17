"""
素数算法题：统计小于 n 的素数个数

题目描述：
    给定一个非负整数 n，统计小于 n 的素数（质数）的个数。
    素数定义为大于 1 且只能被 1 和自身整除的自然数。

示例：
    输入：n = 10
    输出：4
    解释：小于 10 的素数有 [2, 3, 5, 7]

    输入：n = 0
    输出：0

    输入：n = 1
    输出：0
"""


# ============================================================
# 解法一：暴力枚举（适合理解思路，时间复杂度 O(n * sqrt(n))）
# ============================================================
def is_prime_brute(num: int) -> bool:
    """判断 num 是否为素数。"""
    if num < 2:
        return False
    i = 2
    while i * i <= num:
        if num % i == 0:
            return False
        i += 1
    return True


def count_primes_brute(n: int) -> int:
    """暴力解法：逐个判断是否为素数。"""
    return sum(1 for i in range(n) if is_prime_brute(i))


# ============================================================
# 解法二：埃氏筛（Sieve of Eratosthenes，推荐，时间复杂度 O(n log log n)）
# ============================================================
def count_primes_sieve(n: int) -> int:
    """埃拉托斯特尼筛法：用一个布尔数组标记合数。"""
    if n <= 2:
        return 0
    is_prime = [True] * n
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(n ** 0.5) + 1):
        if is_prime[i]:
            # 从 i*i 开始标记（更小的 i*k 已被更小的因子标记过）
            for j in range(i * i, n, i):
                is_prime[j] = False
    return sum(is_prime)


# ============================================================
# 解法三：线性筛（欧拉筛，时间复杂度 O(n)）
# ============================================================
def count_primes_linear(n: int) -> int:
    """线性筛：每个合数只被其最小质因子筛一次。"""
    if n <= 2:
        return 0
    is_prime = [True] * n
    primes = []
    for i in range(2, n):
        if is_prime[i]:
            primes.append(i)
        # 用已有质数去标记 i 与质数的乘积为合数
        for p in primes:
            if i * p >= n:
                break
            is_prime[i * p] = False
            # p 是 i 的最小质因子时停止，否则 i*p 会被更小的质因子筛掉
            if i % p == 0:
                break
    return len(primes)


# ============================================================
# 单元测试
# ============================================================
if __name__ == "__main__":
    test_cases = [
        (0, 0),
        (1, 0),
        (2, 0),
        (3, 1),
        (10, 4),
        (20, 8),
        (100, 25),
        (1000, 168),
    ]

    for fn in (count_primes_brute, count_primes_sieve, count_primes_linear):
        print(f"--- {fn.__name__} ---")
        for n, expected in test_cases:
            result = fn(n)
            status = "PASS" if result == expected else "FAIL"
            print(f"  n={n:>4}  expected={expected:>3}  got={result:>3}  [{status}]")
