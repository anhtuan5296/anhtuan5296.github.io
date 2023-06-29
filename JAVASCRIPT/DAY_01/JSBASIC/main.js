// Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
function giaiThua(number) {
    if (number === 0 || number === 1) {
      return 1;
    } else {
      let t = 1;
      for (let i = 2; i <= number; i++) {
        t *= i;
      }
      return t;
    }
  }
  
  // Ví dụ sử dụng:
  console.log(giaiThua(5)); // Output: 120
// -------------------------------------------------------------------------------------------------------------------------------------


// Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
function reverseString(str) {
    let reversedStr = '';
    for (let i = str.length - 1; i >= 0; i--) {
      reversedStr += str[i];
    }
    return reversedStr;
  }
  
  // Ví dụ:
  console.log(reverseString('hello')); // Output: olleh
// ---------------------------------------------------------------------------------------------------------------------------------

  
// Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
function hello(translate) {
    switch (translate) {
      case 'VN':
        return 'Xin chào';
      case 'EN':
        return 'Hello';
      case 'FR':
        return 'Bonjour';
      default:
        return 'Không tìm thấy ngôn ngữ tương ứng';
    }
  }
  
  // Ví dụ :
  console.log(translate('VN')); // output : Xin chào 
  console.log(translate('EN')); // output : Hello
  console.log(translate('FR')); // output : Bonjuor
// ------------------------------------------------------------------------------------------------------------------------------------

  
// Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.
function subString(str) {
    if (str.length > 15) {
      return str.substring(0, 10) + '...';
    }
    return str;
  }
  
  // Ví dụ:
  console.log(subString('xinchaocacbandenvoiTechmaster')); //output: xinchaocac...

