class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return len(set(s)) == len(set(zip(s, t))) == len(set(t))

sol = Solution();
assert sol.isIsomorphic("egg", "add")
assert sol.isIsomorphic("foo", "bar") == False
assert sol.isIsomorphic("paper", "title")
assert sol.isIsomorphic("eggg", "addf")
