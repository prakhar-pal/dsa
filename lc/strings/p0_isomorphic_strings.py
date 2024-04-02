class Solutionp0_isomorphic_strings.py(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return len(set(s)) == len(set(zip(s, t))) == len(set(t))

sol = Solutionp0_isomorphic_strings.py();
assert sol.isIsomorphic("egg", "add")
assert sol.isIsomorphic("foo", "bar") == False
assert sol.isIsomorphic("paper", "title")
assert sol.isIsomorphic("eggg", "addf")
