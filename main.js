// Mảng màu
let colors = [
  '#3498db',
  '#9b59b6',
  '#e74c3c',
  '#2c3e50',
  '#d35400',
];

// Số lượng box ban đầu
let totalBox = 5;
let addedBoxCount = 0; // Số lượng box đã được thêm vào

// Lấy các phần tử DOM cần sử dụng
const boxesContainer = document.querySelector('.boxes');
const scoreElement = document.querySelector('.points');
const moreBoxButton = document.getElementById('btn');

// Render box ban đầu
renderBoxes(totalBox);

// Đăng ký click cho các box
boxesContainer.addEventListener('click', function (event) {
  const clickedBox = event.target;
  if (clickedBox.classList.contains('box')) {
    removeBox(clickedBox);
  }
});

// Đăng ký  click cho nút "more box"
moreBoxButton.addEventListener('click', function () {
  addMoreBoxes(5);
});

// Hàm render các box ban đầu
function renderBoxes(count) {
  for (let i = 0; i < count; i++) {
    addBox();
  }
  updateTotalBox();
}

// Hàm thêm box mới
function addBox() {
  const box = document.createElement('div');
  box.classList.add('box');
  box.style.backgroundColor = colors[addedBoxCount % colors.length];
  boxesContainer.appendChild(box);
  addedBoxCount++;
  updateTotalBox();
}

// Hàm xóa box
function removeBox(box) {
  box.remove();
  updateTotalBox();
}

// Hàm cập nhật số lượng total box
function updateTotalBox() {
  const boxElements = document.querySelectorAll('.box');
  totalBox = boxElements.length;
  scoreElement.textContent = totalBox;
}

// Hàm thêm nhiều box
function addMoreBoxes(count) {
  for (let i = 0; i < count; i++) {
    addBox();
  }
}