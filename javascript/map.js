function map(array, callback) {
  let finished = [];
  for (let index = 0; index < array.length; index++) {
    let result = callback(array[index], index, array);
    finished.push(result);
  }
  return finished;
}

const main = () => {
  const array = [1, 2, 3, 4];

  let withMap = array.map((a, index) => a + index);
  let withOurMap = map(array, (a, index) => a + index);

  console.log("Given Array: ", array);
  console.log("With builtin map: ", withMap);
  console.log("With our map: ", withOurMap);

  const emptyArray = [];
  console.log("Given Array: ", emptyArray);

  withMap = emptyArray.map((a, index) => a + index);
  withOurMap = map(emptyArray, (a, index) => a + index);

  console.log("With builtin map: ", withMap);
  console.log("With our map: ", withOurMap);
};

main();
