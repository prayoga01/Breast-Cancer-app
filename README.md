# 🎗️ Breast Cancer Screening Information System
### RSUP Prof. Dr. I.G.N.G Ngoerah, Bali

![Laravel](https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white)
![PHP](https://img.shields.io/badge/PHP-777BB4?style=for-the-badge&logo=php&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

> A web-based breast cancer screening system designed specifically for RSUP Prof. Dr. I.G.N.G Ngoerah, Bali. Both the general public and medical staff can perform early digital detection of breast cancer risk by inputting experienced symptoms — the system predicts cancer indication using the Naïve Bayes algorithm.

> **⚠️ Collaborative Project**
> System development (Laravel + Spring Boot) was carried out by [@prayoga01](https://github.com/prayoga01).
> Dataset collection and cleaning were done together with a partner.
> Spring Boot API Repo: [breast-cancer](https://github.com/prayoga01/breast-cancer)

---

## 📋 Background

Breast cancer is the most prevalent disease in Indonesia and ranked 3rd highest at RSUP Ngoerah in 2024. National screening coverage has only reached **14.52%**, with Bali among the **6 lowest provinces** in Indonesia.

Key problems behind this project:
- Extremely low screening coverage both nationally and in Bali
- Electronic medical record data has not been utilized for clinical decision-making
- No digital screening system exists — education is still delivered manually through lectures and BSE (Breast Self-Examination) demonstrations

---

## 🏗️ System Architecture

```
┌─────────────────────┐         ┌──────────────────────┐
│   Laravel (Web App) │ ──API──▶│  Spring Boot (API)   │
│   Frontend + Logic  │◀──JSON──│  Naïve Bayes Model   │
└─────────────────────┘         └──────────────────────┘
         │                                │
         ▼                                ▼
    MySQL Database                  WEKA Dataset
   (users, profiles,             (225 medical records
   prediction, etc.)              from RSUP Ngoerah)
```

- **Laravel** → Web application (UI, authentication, data management)
- **Spring Boot** → REST API for prediction using the Naïve Bayes model
- **WEKA** → Data mining tool for training the model from medical record datasets

---

## 📸 Screenshots

> Create a `/docs/screenshots/` folder in this repo, upload your images, then update the paths below.

**Landing Page**
![Landing Page](docs/screenshots/landing.png)

**Login & Register Page**
![Login Register](docs/screenshots/login.png)

**Symptom Input Form**
![Symptom Form](docs/screenshots/form-gejala.png)

**Prediction Result Page**
![Prediction Result](docs/screenshots/hasil-prediksi.png)

**Selfcare / BSE Education Page**
![Selfcare](docs/screenshots/selfcare.png)

**Prediction History**
![History](docs/screenshots/riwayat.png)

**Prediction History (Admin / Medical Staff)**
![Admin History](docs/screenshots/riwayat-admin.png)

**Admin Dashboard**
![Doctor Dashboard](docs/screenshots/dashboard-admin.png)

---

## ✨ Features

### General User / Patient
- 🔐 Registration & Login
- 📝 Symptom Input Form (with menstrual cycle / menopause validation)
- 🤖 Cancer Risk Prediction (Naïve Bayes)
- 🔑 Examination Code — unique alphanumeric code generated after screening, to share with a doctor
- 🖨️ Print Screening Result
- 📊 Prediction History
- 📚 Selfcare / BSE Education
- 👤 Profile Management

### Doctor
- 🔐 Login — using registered email & password
- 👤 Profile Management (must be completed before accessing panel)
- 🩺 Doctor Panel — enter examination code (received from patient) to access their screening result
- 📋 View Patient Screening Result Detail

### Admin
- 📋 Dashboard
- 🗂️ All Patient Prediction History
- 👨‍⚕️ Manage Doctors
- 👥 Manage Users
---

## 🤖 Prediction Model

| Item | Detail |
|------|--------|
| Algorithm | Naïve Bayes |
| Dataset | 225 electronic medical records from RSUP Ngoerah (Breast Cancer & non-Breast Cancer) |
| Tools | WEKA (pre-processing & training) |
| Validation Split | 80% training / 20% testing |
| Accuracy | **89.90%** |
| Precision | **80%** |
| Recall | **85.70%** |

**Attributes / variables used:**
Risk factors, breast lump, mass growth rate, nipple discharge, nipple retraction, crust, dimpling, peau d'orange, ulceration, venectasia, armpit lump, arm edema, bone pain, shortness of breath

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| Web Framework | PHP, Laravel |
| API Server | Spring Boot (Java) |
| Frontend | Bootstrap, Blade Template |
| Database | MySQL |
| Dev Environment | XAMPP |
| Data Mining | WEKA |
| Development Method | Agile Scrum |

---

## ⚙️ Installation & Setup

### Prerequisites
- PHP >= 8.0
- Composer
- MySQL
- XAMPP
- Node.js & NPM
- Spring Boot API running → [breast-cancer](https://github.com/prayoga01/breast-cancer)

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/prayoga01/Breast-Cancer-app.git
cd Breast-Cancer-app

# 2. Install PHP dependencies
composer install

# 3. Install frontend dependencies
npm install && npm run dev

# 4. Copy the environment file
cp .env.example .env

# 5. Generate app key
php artisan key:generate

# 6. Configure database & API in .env
DB_DATABASE=your_database_name
DB_USERNAME=your_username
DB_PASSWORD=your_password

GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret

# Spring Boot API URL
NAIVEBAYES_API_URL=http://localhost:8080

# 7. Run migrations & seeders
php artisan migrate --seed

# 8. Start the development server
php artisan serve
```

Access the app at `http://localhost:8000`

> **⚠️ Make sure the Spring Boot API is running** at `http://localhost:8080` before using the prediction feature.

---

## 📁 Main Directory Structure

```
Breast-Cancer-app/
├── app/
│   ├── Http/Controllers/
│   └── Models/
├── database/
│   ├── migrations/
│   └── seeders/
├── public/
├── resources/
│   └── views/
│       ├── auth/
│       ├── admin/
│       └── user/
├── routes/
│   └── web.php
└── .env.example
```

---

## 🗄️ Database Structure

| Table | Description |
|-------|-------------|
| `users` | User account data |
| `profiles` | User profile data |
| `contents` | Education / selfcare content |
| `prediction` | Symptom input data for prediction |
| `prediction_result` | Prediction results from the model |
| `doctors` | Doctor data |

---

## 👨‍💻 Developer

**Yoga Pratama** — Fullstack Developer (Laravel + Spring Boot)
- GitHub: [@prayoga01](https://github.com/prayoga01)

**Partner** — Dataset Collection & Data Cleaning
- GitHub: [@lindayuna](https://github.com/lindayuna)

---

## 📝 License

This project was created for research purposes and for the development of a screening system.
