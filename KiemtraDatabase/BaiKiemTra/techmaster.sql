-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2023 lúc 06:33 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `techmaster`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `attendances`
--

CREATE TABLE `attendances` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `attendances`
--

INSERT INTO `attendances` (`id`, `student_id`, `class_id`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 'present', '2023-06-20', NULL, NULL),
(2, 2, 1, 'absent', '2023-06-20', NULL, NULL),
(3, 3, 2, 'present', '2023-06-20', NULL, NULL),
(4, 4, 2, 'late', '2023-06-20', NULL, NULL),
(5, 5, 3, 'present', '2023-06-20', NULL, NULL),
(6, 6, 3, 'present', '2023-06-20', NULL, NULL),
(7, 7, 4, 'absent', '2023-06-20', NULL, NULL),
(8, 8, 4, 'present', '2023-06-20', NULL, NULL),
(9, 9, 5, 'present', '2023-06-20', NULL, NULL),
(10, 10, 5, 'late', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `courses_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `classes`
--

INSERT INTO `classes` (`id`, `courses_id`, `teacher_id`, `name`, `description`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 2, 'Lớp học Lập trình căn bản', 'Lớp học này sẽ giảng dạy các kiến thức cơ bản về lập trình', 'active', '2023-06-20', NULL, NULL),
(2, 2, 3, 'Lớp học Phát triển Web', 'Lớp học này sẽ tập trung vào các kiến thức cơ bản về phát triển Web', 'active', '2023-06-20', NULL, NULL),
(3, 3, 4, 'Lớp học Quản lý Cơ sở dữ liệu', 'Lớp học này sẽ tập trung vào các kiến thức về quản lý cơ sở dữ liệu', 'active', '2023-06-20', NULL, NULL),
(4, 4, 2, 'Lớp học Cấu trúc dữ liệu và thuật toán', 'Lớp học này sẽ giảng dạy các kiến thức cơ bản về cấu trúc dữ liệu và thuật toán', 'active', '2023-06-20', NULL, NULL),
(5, 5, 5, 'Lớp học Lập trình Hướng đối tượng', 'Lớp học này sẽ giảng dạy các kiến thức về lập trình hướng đối tượng', 'active', '2023-06-20', NULL, NULL),
(6, 6, 3, 'Lớp học Phân tích Thiết kế Hệ thống', 'Lớp học này sẽ tập trung vào các kiến thức về phân tích thiết kế hệ thống', 'active', '2023-06-20', NULL, NULL),
(7, 7, 6, 'Lớp học Lập trình Java', 'Lớp học này sẽ giảng dạy các kiến thức cơ bản về lập trình Java', 'active', '2023-06-20', NULL, NULL),
(8, 8, 4, 'Lớp học Phát triển Ứng dụng Di động', 'Lớp học này sẽ tập trung vào các kiến thức cơ bản về phát triển ứng dụng di động', 'active', '2023-06-20', NULL, NULL),
(9, 9, 2, 'Lớp học Thiết kế Giao diện người dùng', 'Lớp học này sẽ giảng dạy các kiến thức về thiết kế giao diện người dùng', 'active', '2023-06-20', NULL, NULL),
(10, 10, 5, 'Lớp học Phương pháp Phát triển phần mềm', 'Lớp học này sẽ giảng dạy các phương pháp phát triển phần mềm hiện đại', 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `teacher_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `courses`
--

INSERT INTO `courses` (`id`, `name`, `description`, `startDate`, `endDate`, `teacher_id`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Giới thiệu về Lập trình', 'Khóa học này giảng dạy các kiến thức cơ bản về lập trình', '2023-07-01', '2023-08-30', 2, 'active', '2023-06-20', NULL, NULL),
(2, 'Phát triển Web', 'Khóa học này bao gồm các kiến thức cơ bản về phát triển Web', '2023-07-15', '2023-09-15', 3, 'active', '2023-06-20', NULL, NULL),
(3, 'Quản lý Cơ sở dữ liệu', 'Khóa học này tập trung vào thiết kế và quản lý cơ sở dữ liệu', '2023-08-01', '2023-09-30', 4, 'active', '2023-06-20', NULL, NULL),
(4, 'Cấu trúc dữ liệu và thuật toán', 'Khóa học này giảng dạy các kiến thức cơ bản về cấu trúc dữ liệu và thuật toán', '2023-07-20', '2023-09-20', 2, 'active', '2023-06-20', NULL, NULL),
(5, 'Lập trình Hướng đối tượng', 'Khóa học này giảng dạy các kiến thức về lập trình hướng đối tượng', '2023-08-10', '2023-10-10', 5, 'active', '2023-06-20', NULL, NULL),
(6, 'Phân tích Thiết kế Hệ thống', 'Khóa học này bao gồm các kiến thức về phân tích thiết kế hệ thống', '2023-08-15', '2023-10-15', 3, 'active', '2023-06-20', NULL, NULL),
(7, 'Lập trình Java', 'Khóa học này giảng dạy các kiến thức cơ bản về lập trình Java', '2023-07-25', '2023-09-25', 6, 'active', '2023-06-20', NULL, NULL),
(8, 'Phát triển Ứng dụng Di động', 'Khóa học này tập trung vào các kiến thức cơ bản về phát triển ứng dụng di động', '2023-08-05', '2023-10-05', 4, 'active', '2023-06-20', NULL, NULL),
(9, 'Thiết kế Giao diện người dùng', 'Khóa học này giảng dạy các kiến thức về thiết kế giao diện người dùng', '2023-09-01', '2023-11-01', 2, 'active', '2023-06-20', NULL, NULL),
(10, 'Phương pháp Phát triển phần mềm', 'Khóa học này giảng dạy các phương pháp phát triển phần mềm hiện đại', '2023-09-10', '2023-11-10', 5, 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lecturedetails`
--

CREATE TABLE `lecturedetails` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lecturedetails`
--

INSERT INTO `lecturedetails` (`id`, `name`, `file_url`, `teacher_id`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Giới thiệu về lập trình', 'https://example.com/1', 1, 'active', '2023-06-20', NULL, NULL),
(2, 'Các loại dữ liệu và biến trong lập trình', 'https://example.com/2', 1, 'active', '2023-06-20', NULL, NULL),
(3, 'Giới thiệu về phát triển Web', 'https://example.com/3', 2, 'active', '2023-06-20', NULL, NULL),
(4, 'HTML cơ bản', 'https://example.com/4', 2, 'active', '2023-06-20', NULL, NULL),
(5, 'Giới thiệu về quản lý cơ sở dữ liệu', 'https://example.com/5', 3, 'active', '2023-06-20', NULL, NULL),
(6, 'SQL cơ bản', 'https://example.com/6', 3, 'active', '2023-06-20', NULL, NULL),
(7, 'Giới thiệu về cấu trúc dữ liệu và thuật toán', 'https://example.com/7', 4, 'active', '2023-06-20', NULL, NULL),
(8, 'Các thuật toán sắp xếp', 'https://example.com/8', 4, 'active', '2023-06-20', NULL, NULL),
(9, 'Lập trình hướng đối tượng với Java', 'https://example.com/9', 5, 'active', '2023-06-20', NULL, NULL),
(10, 'Các tính năng nâng cao của Java', 'https://example.com/10', 5, 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lectures`
--

CREATE TABLE `lectures` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `lectureDetails_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lectures`
--

INSERT INTO `lectures` (`id`, `class_id`, `title`, `lectureDetails_id`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'Giới thiệu về lập trình', 1, 'active', '2023-06-20', NULL, NULL),
(2, 1, 'Các loại dữ liệu và biến trong lập trình', 2, 'active', '2023-06-20', NULL, NULL),
(3, 2, 'Giới thiệu về phát triển Web', 3, 'active', '2023-06-20', NULL, NULL),
(4, 2, 'HTML cơ bản', 4, 'active', '2023-06-20', NULL, NULL),
(5, 3, 'Giới thiệu về quản lý cơ sở dữ liệu', 5, 'active', '2023-06-20', NULL, NULL),
(6, 3, 'SQL cơ bản', 6, 'active', '2023-06-20', NULL, NULL),
(7, 4, 'Giới thiệu về cấu trúc dữ liệu và thuật toán', 7, 'active', '2023-06-20', NULL, NULL),
(8, 4, 'Các thuật toán sắp xếp', 8, 'active', '2023-06-20', NULL, NULL),
(9, 5, 'Lập trình hướng đối tượng với Java', 9, 'active', '2023-06-20', NULL, NULL),
(10, 5, 'Các tính năng nâng cao của Java', 10, 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `points`
--

CREATE TABLE `points` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `nameStudent` varchar(100) DEFAULT NULL,
  `point` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `points`
--

INSERT INTO `points` (`id`, `student_id`, `class_id`, `teacher_id`, `nameStudent`, `point`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 1, 'Nguyễn Văn A', 8.5, 'active', '2023-06-20', NULL, NULL),
(2, 2, 1, 1, 'Trần Thị B', 7, 'active', '2023-06-20', NULL, NULL),
(3, 3, 2, 2, 'Lê Văn C', 9, 'active', '2023-06-20', NULL, NULL),
(4, 4, 2, 2, 'Phạm Thị D', 8, 'active', '2023-06-20', NULL, NULL),
(5, 5, 3, 3, 'Vũ Văn E', 10, 'active', '2023-06-20', NULL, NULL),
(6, 6, 3, 3, 'Nguyễn Thị F', 9.5, 'active', '2023-06-20', NULL, NULL),
(7, 7, 4, 4, 'Trần Văn G', 6.5, 'active', '2023-06-20', NULL, NULL),
(8, 8, 4, 4, 'Lê Thị H', 8, 'active', '2023-06-20', NULL, NULL),
(9, 9, 5, 5, 'Phạm Văn I', 9, 'active', '2023-06-20', NULL, NULL),
(10, 10, 5, 5, 'Vũ Thị K', 7.5, 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `studentclasses`
--

CREATE TABLE `studentclasses` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `nameStudent` varchar(255) NOT NULL,
  `nameClass` varchar(255) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `studentclasses`
--

INSERT INTO `studentclasses` (`id`, `student_id`, `class_id`, `nameStudent`, `nameClass`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 'Nguyễn Văn A', 'Lớp học Lập trình căn bản', 'active', '2023-06-20', NULL, NULL),
(2, 2, 1, 'Trần Thị B', 'Lớp học Lập trình căn bản', 'active', '2023-06-20', NULL, NULL),
(3, 3, 2, 'Lê Minh C', 'Lớp học Phát triển Web', 'active', '2023-06-20', NULL, NULL),
(4, 4, 2, 'Phạm Thị D', 'Lớp học Phát triển Web', 'active', '2023-06-20', NULL, NULL),
(5, 5, 3, 'Võ Văn E', 'Lớp học Quản lý Cơ sở dữ liệu', 'active', '2023-06-20', NULL, NULL),
(6, 6, 3, 'Đặng Thị F', 'Lớp học Quản lý Cơ sở dữ liệu', 'active', '2023-06-20', NULL, NULL),
(7, 7, 4, 'Nguyễn Thị G', 'Lớp học Cấu trúc dữ liệu và thuật toán', 'active', '2023-06-20', NULL, NULL),
(8, 8, 4, 'Trần Văn H', 'Lớp học Cấu trúc dữ liệu và thuật toán', 'active', '2023-06-20', NULL, NULL),
(9, 9, 5, 'Lê Thị I', 'Lớp học Lập trình Hướng đối tượng', 'active', '2023-06-20', NULL, NULL),
(10, 10, 5, 'Phạm Văn K', 'Lớp học Lập trình Hướng đối tượng', 'active', '2023-06-20', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `role`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Nguyễn Văn A', 'nguyenvana@gmail.com', 'password123', '0987654321', 'student', 'active', '2023-06-20', '2023-06-20', NULL),
(2, 'Trần Thị B', 'tranthib@gmail.com', 'password456', '0912345678', 'teacher', 'active', '2023-06-20', '2023-06-20', NULL),
(3, 'Lê Văn C', 'levanc@gmail.com', 'password789', '0901234567', 'student', 'inactive', '2023-06-20', '2023-06-20', NULL),
(4, 'Phạm Thị D', 'phamthid@gmail.com', 'password789', '0987654321', 'student', 'active', '2023-06-20', '2023-06-20', NULL),
(5, 'Đặng Văn E', 'dangvane@gmail.com', 'password123', '0909090909', 'teacher', 'active', '2023-06-20', '2023-06-20', NULL),
(6, 'Hoàng Thị F', 'hoangthif@gmail.com', 'password456', '0911111111', 'teacher', 'inactive', '2023-06-20', '2023-06-20', NULL),
(7, 'Bùi Văn G', 'buivang@gmail.com', 'password789', '0912345678', 'student', 'active', '2023-06-20', '2023-06-20', NULL),
(8, 'Trương Thị H', 'truongthih@gmail.com', 'password789', '0909090909', 'student', 'inactive', '2023-06-20', '2023-06-20', NULL),
(9, 'Ngô Văn I', 'ngovanI@gmail.com', 'password123', '0987654321', 'teacher', 'active', '2023-06-20', '2023-06-20', NULL),
(10, 'Vũ Thị K', 'vuthik@gmail.com', 'password456', '0911111111', 'teacher', 'active', '2023-06-20', '2023-06-20', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `attendances`
--
ALTER TABLE `attendances`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Chỉ mục cho bảng `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `courses_id` (`courses_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Chỉ mục cho bảng `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Chỉ mục cho bảng `lecturedetails`
--
ALTER TABLE `lecturedetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Chỉ mục cho bảng `lectures`
--
ALTER TABLE `lectures`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `lectureDetails_id` (`lectureDetails_id`);

--
-- Chỉ mục cho bảng `points`
--
ALTER TABLE `points`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Chỉ mục cho bảng `studentclasses`
--
ALTER TABLE `studentclasses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `attendances`
--
ALTER TABLE `attendances`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `lecturedetails`
--
ALTER TABLE `lecturedetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `lectures`
--
ALTER TABLE `lectures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `points`
--
ALTER TABLE `points`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `studentclasses`
--
ALTER TABLE `studentclasses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `attendances`
--
ALTER TABLE `attendances`
  ADD CONSTRAINT `attendances_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `attendances_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

--
-- Các ràng buộc cho bảng `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`courses_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `lecturedetails`
--
ALTER TABLE `lecturedetails`
  ADD CONSTRAINT `lecturedetails_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `lectures`
--
ALTER TABLE `lectures`
  ADD CONSTRAINT `lectures_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `lectures_ibfk_2` FOREIGN KEY (`lectureDetails_id`) REFERENCES `lecturedetails` (`id`);

--
-- Các ràng buộc cho bảng `points`
--
ALTER TABLE `points`
  ADD CONSTRAINT `points_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `points_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `points_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `studentclasses`
--
ALTER TABLE `studentclasses`
  ADD CONSTRAINT `studentclasses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `studentclasses_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
