CREATE DATABASE quanlyshop;
USE quanlyshop;
CREATE TABLE tbl_nguoidung (
  id int PRIMARY KEY AUTO_INCREMENT,
  ten varchar(100),
  sdt varchar(20),
  diaChi varchar(255),
  username varchar(100),
  password varchar(50),
  email varchar(100),
  ngayVaoLam timestamp,
  vaitro_id integer,
  cccd varchar(50),
  trangThai integer,
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_vaitro (
  id integer PRIMARY KEY AUTO_INCREMENT,
  khoa varchar(255),
  tenVaiTro varchar(50),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_luong (
  id integer PRIMARY KEY AUTO_INCREMENT,
  nhanvien_id integer,
  luongCung float,
  thuong float,
  phat float,
  thue float,
  soNgayCong float,
  thang integer,
  trangThai varchar(50),
  created_at date,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_doanhso (
  id integer PRIMARY KEY AUTO_INCREMENT,
  nhanvien_id integer,
  soHoaDon integer, 
  heSo float,
  thang integer,
  trangThai varchar(50),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_sanpham (
  id integer PRIMARY KEY AUTO_INCREMENT,
  tenSanPham varchar(255),
  soLuong integer,
  gia float,
  danhmuc_id integer,
  nhacungcap_id integer,
  ngaySanXuat date ,
  moTa varchar(255),
  trangThai varchar(100),
  hinhAnh varchar(255),
  chiTiet varchar(255),
  thongSo varchar(255),
  ngayNhap date ,
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_giohang (
  id integer PRIMARY KEY AUTO_INCREMENT,
  khachhang_id integer,
  trangThai varchar(50),
  created_at ,
  updated_at ,
  deleted_at 
); 
CREATE Table tbl_chitietgiohang (
  id integer PRIMARY KEY AUTO_INCREMENT,
  giohang_id integer,
  sanpham_id integer,
  soLuong integer,
  created_at date ,
  CONSTRAINT fk_tbl_luong_tbl_giohang FOREIGN KEY (giohang_id) REFERENCES tbl_giohang(id),
  CONSTRAINT fk_tbl_luong_tbl_sanpham FOREIGN KEY (sanpham_id) REFERENCES tbl_sanpham(id)
);
CREATE Table tbl_hoadon (
  id integer PRIMARY KEY AUTO_INCREMENT,
  khachhang_id integer,
  giohang_id integer,
  nhanvien_id integer,
  trangThai varchar(50),
  ngayLapHD datetime,
  diaChi varchar(255),
  sdt varchar(20),
  ghiChu varchar(255),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table tbl_chitiethoadon (
  id integer PRIMARY KEY AUTO_INCREMENT,
  giohang_id integer,
  sanpham_id integer,
  soLuong integer,
  donGia float,
  tenSanPham varchar(255),
  hinhAnh varchar(255),
  created_at date 
);
CREATE Table tbl_danhgia (
  id integer PRIMARY KEY AUTO_INCREMENT,
  sanpham_id integer,
  diemSo float,
  khachhang_id integer,
  comment varchar(255),
  trangThai varchar(50),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table nhacungcap (
  id integer PRIMARY KEY AUTO_INCREMENT,
  tenNCC varchar(100),
  moTa varchar(255),
  hinhAnh varchar(255),
  trangThai varchar(50),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
CREATE Table danhmuc (
  id integer PRIMARY KEY AUTO_INCREMENT,
  tenDanhMuc varchar(100),
  hinhAnh varchar(255),
  moTa varchar(255),
  trangThai varchar(100),
  created_at date ,
  updated_at date ,
  deleted_at date 
);
