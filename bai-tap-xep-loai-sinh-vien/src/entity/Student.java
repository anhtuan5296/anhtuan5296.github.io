package entity;


    public class Student {
        public static int autoId;
        private int id;
        private String name;
        private double scoreMath;
        private double scorePhysics;
        private double scoreChemistry;

        public Student() {
            this.id = ++autoId;
        }

        public Student(String name, double scoreMath, double scorePhysics, double scoreChemistry) {
            this.id = ++autoId;
            this.name = name;
            this.scoreMath = scoreMath;
            this.scorePhysics = scorePhysics;
            this.scoreChemistry = scoreChemistry;
        }

        public double avgScore() {
            return ((this.scoreMath + this.scorePhysics + this.scoreChemistry) / 3);
        }

        public String classification() {
            if (avgScore() >= 8) {
                return "A";
            } else if (avgScore() < 8 && avgScore() >= 6.5) {
                return "B";
            } else {
                return "C";
            }
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public double getScoreMath() {
            return this.scoreMath;
        }

        public double getScorePhysics() {
            return this.scorePhysics;
        }

        public double getScoreChemistry() {
            return this.scoreChemistry;
        }

        @Override
        public String toString() {
            return "{" +
                    " id='" + getId() + "'" +
                    ", Tên='" + getName() + "'" +
                    ", Điểm môn Toán ='" + getScoreMath() + "'" +
                    ", Điểm môn Vật Lý ='" + getScorePhysics() + "'" +
                    ", Điểm môn Hóa ='" + getScoreChemistry() + "'" +
                    ", Điểm trung bình='" + avgScore() + "'" +
                    ", Xếp loại sinh viên='" + classification() + "'" +
                    "}";
        }
    }

