// Bài 1
const text = document.getElementById("text");
text.style.color = "#777";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em>bất cứ điều gì</em> tôi muốn với JavaScript.";


// Bài 2 
const li = document.querySelectorAll("li");
for (let i = 0; i < 3; i++) {
  li[i].style.color = "blue";
}


//Bài 3
// 1 Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
const li8 = document.createElement("li");
const li9 = document.createElement("li");
const li10 = document.createElement("li");

// thêm nội dung vào các li
li8.textContent = "Item 8";
li9.textContent = "Item 9";
li10.textContent = "Item 10";

// Xác định ul #list
const ul = document.querySelector("#list");

// Thêm 3 tag mới vào cuối ul
ul.appendChild(li8);
ul.appendChild(li9);
ul.appendChild(li10);

// Sửa li1 thành màu đỏ
let li1 = document.querySelector("#list > li");
li1.style.color = "red";

// Sửa background cho thẻ <li> 3 thành màu xanh 
let li3 = document.querySelector("#list :nth-child(3)");
li3.style.backgroundColor = "green";
console.log(li3);
// Remove thẻ <li> 4
let li4 = document.querySelector("#list :nth-child(4)");
ul.removeChild(li4);

// Thêm một thẻ <li> mới thay thế cho thẻ <li> 4 đã bị xóa
let newLi4 = document.createElement("li");
newLi4.textContent = "Đây là Item 4 mới";
li3.insertAdjacentElement("afterend",newLi4);

