// Lấy danh sách giống loài chính và hiển thị
fetch('https://dog.ceo/api/breeds/list/all')
  .then(response => response.json())
  .then(data => {
    const mainBreedList = document.getElementById('main-breed-list');
    const breeds = Object.keys(data.message);
    for (let i = 0; i < breeds.length; i++) {
      const breed = breeds[i];
      const breedOption = document.createElement('option');
      breedOption.textContent = breed;
      mainBreedList.appendChild(breedOption);
    }
  });

// Hiển thị danh sách giống loài phụ khi người dùng chọn một giống loài chính
const subBreedsListContainer = document.getElementById('sub-breeds-list-container');
const mainBreedList = document.getElementById('main-breed-list');
const getSubBreedsBtn = document.getElementById('get-sub-breeds-btn');
getSubBreedsBtn.addEventListener('click', () => {
  const selectedMainBreed = mainBreedList.value;
  fetch(`https://dog.ceo/api/breed/${selectedMainBreed}/list`)
    .then(response => response.json())
    .then(data => {
      subBreedsListContainer.innerHTML = '';
      const subBreeds = data.message;
      if (subBreeds.length === 0) {
        const noSubBreedOption = document.createElement('p');
        noSubBreedOption.textContent = 'No sub-breed';
        subBreedsListContainer.appendChild(noSubBreedOption);
      } else {
        const subBreedsList = document.createElement('ul');
        subBreedsList.classList.add('sub-breeds-list');
        for (let i = 0; i < subBreeds.length; i++) {
          const subBreed = subBreeds[i];
          const subBreedItem = document.createElement('li');
          subBreedItem.textContent = subBreed;
          subBreedItem.addEventListener('click', () => {
            getSubBreedImage(selectedMainBreed, subBreed);
          });
          subBreedsList.appendChild(subBreedItem);
        }
        subBreedsListContainer.appendChild(subBreedsList);
      }
    });
});

// Hiển thị ảnh random của giống loài phụ
const randomImageContainer = document.getElementById('random-image-container');
const getSubBreedImage = (mainBreed, subBreed) => {
  fetch(`https://dog.ceo/api/breed/${mainBreed}/${subBreed}/images/random`)
    .then(response => response.json())
    .then(data => {
      randomImageContainer.innerHTML = '';
      const dogImage = document.createElement('img');
      dogImage.src = data.message;
      randomImageContainer.appendChild(dogImage);
    });
};