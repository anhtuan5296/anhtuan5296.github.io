const todoList = document.getElementById('list');
const addTodoBtn = document.getElementById('add-todo-btn');
const newTodoTitle = document.getElementById('new-todo-title');

let todos = [];

function renderTodos() {
  todoList.innerHTML = '';
  if (todos.length === 0) {
    const emptyMessage = document.createElement('p');
    emptyMessage.textContent = 'Danh sách công việc trống';
    todoList.appendChild(emptyMessage);
  } else {
    todos.forEach((todo, index) => {
      const todoItem = document.createElement('li');
      const todoCheckbox = document.createElement('input');
      todoCheckbox.type = 'checkbox';
      todoCheckbox.checked = todo.completed;
      todoCheckbox.addEventListener('change', () => {
        todos[index].completed = todoCheckbox.checked;
        renderTodos();
      });
      todoItem.appendChild(todoCheckbox);
      const todoTitle = document.createElement('span');
      todoTitle.textContent = todo.title;
      if (todo.completed) {
        todoTitle.classList.add('completed');
      }
      todoItem.appendChild(todoTitle);
      const editBtn = document.createElement('button');
      editBtn.textContent = 'Edit';
      editBtn.addEventListener('click', () => {
        const newTitle = prompt('Nhập tiêu đề mới:', todo.title);
        if (newTitle !== null && newTitle.trim() !== '') {
          todos[index].title = newTitle.trim();
          renderTodos();
        }
      });
      todoItem.appendChild(editBtn);
      const deleteBtn = document.createElement('button');
      deleteBtn.textContent = 'Delete';
      deleteBtn.addEventListener('click', () => {
        const confirmed = confirm('Bạn có chắc chắn muốn xóa công việc này?');
        if (confirmed) {
          todos.splice(index, 1);
          renderTodos();
        }
      });
      todoItem.appendChild(deleteBtn);
      todoList.appendChild(todoItem);
    });
  }
}

addTodoBtn.addEventListener('click', () => {
  const title = newTodoTitle.value.trim();
  if (title === '') {
    alert('Tên công việc không được để trống');
  } else {
    todos.push({ title, completed: false });
    newTodoTitle.value = '';
    renderTodos();
  }
});

todos.push({ title: 'Đi chơi', completed: false });
todos.push({ title: 'Học bài', completed: false });
todos.push({ title: 'Đá bóng', completed: false });

renderTodos();
