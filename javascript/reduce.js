function reduce(array, reducer, initialValue) {
  let accumulator = initialValue === undefined ? array[0] : initialValue;
  let index = initialValue === undefined ? 1 : 0;
  for (index; index < array.length; index++) {
    accumulator = reducer(accumulator, array[index], index, array);
  }
  return accumulator;
}

const main = () => {
  const array = [0, 1, 4, 5, 7];

  let withReduce = array.reduce((acc, a, index) => acc + a, 3);
  let withOurReduce = reduce(array, (acc, a, index) => acc + a, 3);

  console.log("Given Array: ", array);
  console.log("With builtin reduce: ", withReduce);
  console.log("With our reduce: ", withOurReduce);

  let emptyArray = [];

  withReduce = emptyArray.reduce((acc, a, index) => acc + a, 3);
  withOurReduce = reduce(emptyArray, (acc, a, index) => acc + a, 3);

  console.log("Given Array: ", emptyArray);
  console.log("With builtin reduce: ", withReduce);
  console.log("With our reduce: ", withOurReduce);
};

main();
