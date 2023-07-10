const grades = [
    {name: 'John', grade: 8, sex: 'M'},
    {name: 'Sarah', grade: 12, sex: 'F'},
    {name: 'Bob', grade: 16, sex: 'M'},
    {name: 'Johnny', grade: 2, sex: 'M'},
    {name: 'Ethan', grade: 4, sex: 'M'},
    {name: 'Paula', grade: 18, sex: 'F'},
    {name: 'Donald', grade: 5, sex: 'M'},
    {name: 'Jennifer', grade: 13, sex: 'F'},
    {name: 'Courtney', grade: 15, sex: 'F'},
    {name: 'Jane', grade: 9, sex: 'F'}
  ];
  
  // Tính thứ hạng trung bình của cả lớp
  function Average() {
    let t = 0;
    for (let i = 0; i < grades.length; i++) {
      t += grades[i].grade;
    }
    return t / grades.length;
  }
  
  // Tính thứ hạng trung bình của nam trong lớp
  function MaleAverage() {
    let total = 0;
    let count = 0;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'M') {
        total += grades[i].grade;
        count++;
      }
    }
    return total / count;
  }
  
  // Tính thứ hạng trung bình của nữ trong lớp
  function FemaleAverage() {
    let total = 0;
    let count = 0;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'F') {
        total += grades[i].grade;
        count++;
      }
    }
    return total / count;
  }
  
  // Tìm học viên nam có thứ hạng cao nhất trong lớp
  function findHighestMaleStudent() {
    let highestGrade = 0;
    let highestMaleStudent = null;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'M' && grades[i].grade > highestGrade) {
        highestGrade = grades[i].grade;
        highestMaleStudent = grades[i];
      }
    }
    return highestMaleStudent;
  }
  
  // Tìm học viên nữ có thứ hạng cao nhất trong lớp
  function findHighestFemaleStudent() {
    let highestGrade = 0;
    let highestFemaleStudent = null;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'F' && grades[i].grade > highestGrade) {
        highestGrade = grades[i].grade;
        highestFemaleStudent = grades[i];
      }
    }
    return highestFemaleStudent;
  }
  
  // Tìm học viên nam có thứ hạng thấp nhất trong lớp
  function findLowestMaleStudent() {
    let lowestGrade = Infinity;
    let lowestMaleStudent = null;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'M' && grades[i].grade < lowestGrade) {
        lowestGrade = grades[i].grade;
        lowestMaleStudent = grades[i];
      }
    }
    return lowestMaleStudent;
  }
  
  // Tìm học viên nữ có thứ hạng thấp nhất trong lớp
  function findLowestFemaleStudent() {
    let lowestGrade = Infinity;
    let lowestFemaleStudent = null;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'F' && grades[i].grade < lowestGrade) {
        lowestGrade = grades[i].grade;
        lowestFemaleStudent = grades[i];
      }
    }
    return lowestFemaleStudent;
  }
  
  // Thứ hạng cao nhất của cả lớp
  function findHighestGrade() {
    let highestGrade = 0;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].grade > highestGrade) {
        highestGrade = grades[i].grade;
      }
    }
    return highestGrade;
  }
  
  // Thứ hạng thấp nhất của cả lớp
  function findLowestGrade() {
    let lowestGrade = Infinity;
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].grade < lowestGrade) {
        lowestGrade = grades[i].grade;
      }
    }
    return lowestGrade;
  }
  
  // Lấy danh sách tất cả học viên nữ trong lớp
  function getFemaleStudents() {
    const femaleStudents = [];
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'F') {
        femaleStudents.push(grades[i]);
      }
    }
    return femaleStudents;
  }
  
  // Sắp xếp tên học viên theo chiều tăng dần của bảng chữ cái
  function sortStudentsByName() {
    const sortedGrades = [...grades];
    sortedGrades.sort((a, b) => a.name.localeCompare(b.name));
    return sortedGrades;
  }
  
  // Sắp xếp thứ hạng học viên theo chiều giảm dần
  function sortStudentsByGradeDescending() {
    const sortedGrades = [...grades];
    sortedGrades.sort((a, b) => b.grade - a.grade);
    return sortedGrades;
  }
  
  // Lấy học viên nữ có tên bắt đầu bằng "J"
  function getFemaleStudentsStartingWithJ() {
    const femaleStudentsStartingWithJ = [];
    for (let i = 0; i < grades.length; i++) {
      if (grades[i].sex === 'F' && grades[i].name.startsWith('J')) {
        femaleStudentsStartingWithJ.push(grades[i]);
      }
    }
    return femaleStudentsStartingWithJ;
  }
  
  // Lấy top 5 người có thứ hạng cao nhất trong lớp
  function getTop5Students() {
    const sortedGrades = sortStudentsByGradeDescending();
    return sortedGrades.slice(0, 5);
  }
  
  // Kiểm tra kết quả 
  console.log('Thứ hạng trung bình của cả lớp:', Average());
  console.log('Thứ hạng trung bình của nam trong lớp:', MaleAverage());
  console.log('Thứ hạng trung bình của nữ trong lớp:', FemaleAverage());
  console.log('Học viên nam có thứ hạng cao nhất trong lớp:', findHighestMaleStudent());
  console.log('Học viên nữ có thứ hạng cao nhất trong lớp:', findHighestFemaleStudent());
  console.log('Học viên nam có thứ hạng thấp nhất trong lớp:', findLowestMaleStudent());
  console.log('Học viên nữ có thứ hạng thấp nhất trong lớp:', findLowestFemaleStudent());
  console.log('Thứ hạng cao nhất của cả lớp:', findHighestGrade());
  console.log('Thứ hạng thấp nhất của cả lớp:', findLowestGrade());
  console.log('Danh sách học viên nữ trong lớp:', getFemaleStudents());
  console.log('Danh sách học viên theo tên tăng dần:', sortStudentsByName());
  console.log('Danh sách học viên theo thứ hạng giảm dần:', sortStudentsByGradeDescending());
  console.log('Học viên nữ có tên bắt đầu bằng "J":', getFemaleStudentsStartingWithJ());
  console.log('Top 5 học viên có thứ hạng cao nhất:', getTop5Students());

