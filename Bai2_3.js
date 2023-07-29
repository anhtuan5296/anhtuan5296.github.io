// Bai 2
const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];

function randomizeAnswers() {
    quizes.forEach((quiz) => {
        const randomAnswerIndex = Math.floor(Math.random() * quiz.answers.length);
        const inputElements = document.querySelectorAll(`input[name="${quiz.id}"]`);
        inputElements.forEach((input, index) => {
            input.checked = index === randomAnswerIndex;
        });
    });
}

document.getElementById("btn").addEventListener("click", randomizeAnswers);

// Bai 3
const navItems = document.querySelectorAll('.nav-item');
const postContainer = document.getElementById('post-container');

function displayPosts(resource) {
    fetch(`https://jsonplaceholder.typicode.com/${resource}`)
        .then((response) => response.json())
        .then((data) => {
            postContainer.innerHTML = '';
            data.forEach((item) => {
                const postItem = document.createElement('li');
                postItem.className = 'post-item';
                postItem.textContent = item.title;
                postContainer.appendChild(postItem);
            });
        });
}
navItems.forEach((item) => {
    item.addEventListener('click', () => {
        navItems.forEach((navItem) => {
            navItem.classList.remove('active');
        });
        item.classList.add('active');
        const resource = item.getAttribute('data-resource');
        displayPosts(resource);
    });
});
displayPosts('posts');