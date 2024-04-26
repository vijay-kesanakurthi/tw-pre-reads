function forEach(array, callback) {
  for (var index = 0; index < array.length; index++)
    callback(array[index], index, array);
}

const main = () => {
  const array = [0, 1, 4, 5, 7];

  console.log("Given Array: ", array);
  console.log("With builtin forEach");
  array.forEach((a, index) => console.log(a, index));

  console.log("With our forEach");
  forEach(array, (a, index) => console.log(a, index));

  const emptyArray = [];
  console.log("Given Array: ", emptyArray);
  console.log("With builtin forEach");
  emptyArray.forEach((a, index) => console.log(a, index));
  console.log("With our forEach");
  forEach(emptyArray, (a, index) => console.log(a, index));
};

main();
