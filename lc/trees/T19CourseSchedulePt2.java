package lc.trees;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class T19CourseSchedulePt2 {
    public static void main(String[] args) {
        T19SolutionOne solution = new T19SolutionOne();
        assert ArrayUtils.isSame1DArray(solution.findOrder(2, new int[][] {
            {1, 0}
        }), new int[] {0,1});

        assert ArrayUtils.isSame1DArray(solution.findOrder(2, new int[][] {
            {1, 0},
            {0,1}
        }), new int[] {});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {2, 1},
            {1,0}
        }), new int[] {0,1,2});

        assert ArrayUtils.isSame1DArray(solution.findOrder(2, new int[][] {
        }), new int[] {0,1});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {2,0},
            {2,1}
        }), new int[] {0,1,2});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {2,0}
        }), new int[] {0,1,2});

        assert ArrayUtils.isSame1DArray(solution.findOrder(4, new int[][] {
            {2,1},
            {3,2},
            {1,0}
        }), new int[] {0,1,2,3});

        assert ArrayUtils.isSame1DArray(solution.findOrder(4, new int[][] {
            {2,1},
            {3,2},
            {1,0},
            {0,3}
        }), new int[] {});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {1,0},
            {2,0},
        }), new int[] {0,1,2});

        assert ArrayUtils.isSame1DArray(solution.findOrder(5, new int[][] {
            {1,4},
            {2,4},
            {3,1},
            {3,2}
        }), new int[] {0,4,1,2,3});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {1,0},
            {1,2},
            {0,1},
        }), new int[] {});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {0,1},
            {0,2},
            {1,0},
        }), new int[]{});

        assert ArrayUtils.isSame1DArray(solution.findOrder(3, new int[][] {
            {0,1},
            {0,2},
            {1,2},
        }), new int[] {2,1,0});
    }
}

class T19Course {
    public int courseId;
    public int inCount;
    public HashSet<T19Course> dependents;
    public T19Course(int courseId) {
        this.courseId = courseId;
        inCount = 0;
        dependents = new HashSet<>();
    }
    public int hashCode() {
        return Objects.hash(this.courseId);
    }
}


class T19SolutionOne {
    // this is solved using kahn's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        T19Course[] courses = new T19Course[numCourses];
        for(int i=0;i<numCourses;i++) {
            courses[i] = new T19Course(i);
        }
        for(int i=0;i<prerequisites.length;i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            courses[b].dependents.add(courses[a]);
            courses[a].inCount++;
        }
        Queue<Integer> courseQueue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(courses[i].inCount == 0) {
                courseQueue.add(courses[i].courseId);
            }
        }
        int[] courseOrder = new int[numCourses];
        int courseIndex = 0;
        while(courseQueue.size() != 0) {
            T19Course course = courses[courseQueue.poll()];
            courseOrder[courseIndex++] = course.courseId;
            for(T19Course dependent: course.dependents) {
                dependent.inCount--;
                if(dependent.inCount == 0) {
                    courseQueue.add(dependent.courseId);
                }
            }
        }
        return courseIndex == numCourses ? courseOrder: new int[] {};
    }
}

