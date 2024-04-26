function filter(array, callback) {
  let finished = [];
  for (let index = 0; index < array.length; index++) {
    let result = callback(array[index], index, array);
    if (result) {
      finished.push(array[index]);
    }
  }
  return finished;
}

const main = () => {
  const array = [0, 1, 4, 5, 7];

  let withMap = array.filter((a, index) => a > index);
  let withOurMap = filter(array, (a, index) => a > index);

  console.log("Given Array: ", array);
  console.log("With builtin filter: ", withMap);
  console.log("With our filter: ", withOurMap);

  const emptyArray = [];
  console.log("Given Array: ", emptyArray);

  withMap = emptyArray.filter((a, index) => a > index);
  withOurMap = filter(emptyArray, (a, index) => a > index);

  console.log("With builtin filter: ", withMap);
  console.log("With our filter: ", withOurMap);
};

main();
