// 1. Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là một mảng các chuỗi có độ dài lớn nhất:


function getStringHasMaxLength(arr) {
  let maxLength = 0;
  let result = [];

  for (let i = 0; i < arr.length; i++) {
    if (arr[i].length > maxLength) {
      maxLength = arr[i].length;
      result = [arr[i]];
    } else if (arr[i].length === maxLength) {
      result.push(arr[i]);
    }
  }

  return result;
}

// Ví dụ:
console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd'])); // Output: ['aba', 'vcd'].



// 2. Viết function truyền vào mảng các object user. Trả về mảng các user có age > 25 và isStatus = true:


function filterUsersByAgeAndStatus(users) {
  return users.filter(user => user.age > 25 && user.isStatus === true);
}

// Ví dụ:
const users = [
  {
    name: "Bùi Công Sơn",
    age: 30,
    isStatus: true,
  },
  {
    name: "Nguyễn Thu Hằng",
    age: 27,
    isStatus: false,
  },
  {
    name: "Phạm Văn Dũng",
    age: 20,
    isStatus: false,
  }
];

console.log(filterUsersByAgeAndStatus(users)); // Output: [{ name: 'Bùi Công Sơn', age: 30, isStatus: true }]



// 3. Viết function truyền vào mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần:


function getCountElement(arr) {
  const countObject = {};

  arr.forEach(element => {
    if (countObject[element]) {
      countObject[element]++;
    } else {
      countObject[element] = 1;
    }
  });

  return countObject;
}

// Ví dụ:
console.log(getCountElement(["one", "two", "three", "one", "one", "three"]));
// Output: { one: 3, two: 1, three: 2 }