// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
function findMinArrowShots(points: number[][]): number {
  let count = 0;
  points.sort((point1, point2) => {
    if (point1[0] > point2[0]) {
      return 1;
    } else if (point1[0] === point2[0]) {
      return 0;
    }
    return -1;
  });
  console.log(points);
  let i = 0;
  while (i < points.length) {
    console.log("processing index:", i);
    let nextIndex = i + 1;
   // 1. check if next point overlaps with the current point
    if(i+1 < points.length && points[i+1][0] <= points[i][1]) {
      // 2. check if more than two balloons intersect
      let intersectionLength = nextIntersections(points, i + 2, [points[i+1][0], Math.min(points[i][1], points[i+1][1])]);
      nextIndex = i + 2 + intersectionLength;
    }
    i = nextIndex;
    count++;
  }
  return count;
};

function nextIntersections(points: number[][], index: number, range:number[]): number {
  let len = 0;
  while(index < points.length && points[index][0] <= range[0] && points[index][1] >= range[1]) {
    index++;
    len++;
  }
  return len;
}


// console.log(findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]));
// console.log(findMinArrowShots([[1,2],[3,4],[5,6],[7,8]]));
// console.log(findMinArrowShots([[1,2],[2,3],[3,4],[4,5]]));
console.log(findMinArrowShots([[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]));
