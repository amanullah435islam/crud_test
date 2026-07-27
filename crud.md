					Imran sir code postman check



সম্পূর্ণ Login Flow:

User Login Request
        │
        ▼
Email + Password
        │
        ▼
AuthenticationManager
        │
        ▼
UserDetailsService
        │
        ▼
UserRepository.findByEmail(email)
        │
        ▼
User Entity
        │
        ▼
getUsername()
getPassword()
getAuthorities()
isEnabled()
isAccountNonLocked()
isAccountNonExpired()
isCredentialsNonExpired()
        │
        ▼
Password Match?
        │
   Yes ─────────► Generate JWT / Create Session
    │
    No
    ▼
Authentication Failed




Flow OneToOne centralized design flow :

                      Doctor Registration

                      ↓

                      Create User

                      ↓

                      Save User

                      ↓

                      User id generated

                      ↓

                      Create Doctor

                      ↓

                      Doctor.user = Saved User

                      ↓

                      Save Doctor

                      ↓

                      Doctor Table gets user_id


পুরো Flow (User ↔ Doctor) :

                Doctor Registration
                        │
                        ▼
               Create User Object
                        │
                        ▼
                Save User Table
                        │
                (ID generated)
                        │
                        ▼
              Create Doctor Object
                        │
        doctor.setUser(savedUser)
                        │
                        ▼
              Save Doctor Table
                        │
                        ▼
        doctors.user_id = users.id





User & Doctor code Explain:

Interview Questions:-
UserDetails কেন implement করেছ?
Spring Security যেন User entity-কেই Authentication-এর জন্য ব্যবহার করতে পারে।
getUsername()-এ email return করেছ কেন?
কারণ Login Email দিয়ে হবে, Username দিয়ে নয়।
@Enumerated(EnumType.STRING) কেন?
Role Database-এ ADMIN, DOCTOR ইত্যাদি String আকারে Save হবে; Number Save করলে ভবিষ্যতে Enum order বদলালে সমস্যা হতে পারে।
mappedBy কেন ব্যবহার করা হয়েছে?
Doctor side relationship-এর owner। তাই User side-এ mappedBy="user" দিয়ে inverse side দেখানো হয়েছে।
FetchType.LAZY কেন?
Doctor Load করার সময় অপ্রয়োজনীয়ভাবে User Load না করে Performance ভালো রাখতে।
CascadeType.ALL কেন?
Parent entity-এর operation (save/update/delete) Child entity-তেও Apply করার জন্য।







1. Login
POST

http://localhost:8080/api/auth/login

Body (JSON)
{
  "email":"aman@gmail.com",
  "password":"1234"
}

Expected response:

{
  "token":"eyJhbGciOiJIUzI1NiJ9...",
  "tokenType":"Bearer",
  "userId":1,
  "name":"Aman",
  "email":"aman@gmail.com",
  "role":"DOCTOR"
}


2. Verify Email

তোমার controller:

@GetMapping("/verify-email")

GET

http://localhost:8080/api/auth/verify-email?token=TOKEN_HERE


Expected:

Email verified successfully. You can now log in.



3. Forgot Password
POST

http://localhost:8080/api/auth/forgot-password

Body
{
  "email":"aman@gmail.com"
}

Expected:

Password reset link sent to aman@gmail.com

এরপর Gmail-এ mail যাবে। 📧



4. Reset Password

Mail-এ যে link আসবে সেখানে token= এর value copy করো।

POST

http://localhost:8080/api/auth/reset-password

Body
{
  "token":"eyJhbGciOiJIUzI1NiJ9....",
  "newPassword":"new1234"
}

Expected:

Password reset successful. You can now log in with your new password.



angular alternative:
app.frontend-url=http://localhost:8080/api/auth


without angular:

ami jokon forgate password postman a hit kori than mail a akta notification ase "Password Reset Request
Hi Dr Amanullah, we received a request to reset your password.

Reset Password

This link expires in 15 minutes. If you didn't request this, you can safely ignore this email — your password will not change.", than red button "Reset Password" korle jodio akta error ase than akta token generate hoi oi token dia reset-password endpoint ar body te bosaile & new pass password dile successfull hoi"Password reset successful. You can now log in with your new password.".....


forgate-password to reset-password all process:::::
Step 1

User

Forgot Password

↓

Backend mail পাঠাবে

http://localhost:4200/reset-password?token=xxxxx

↓

Step 2

Angular Page খুলবে

Reset Password Form

New Password
Confirm Password

↓

Step 3

User password লিখবে

↓

Angular POST করবে

POST /api/auth/reset-password

Body

{
  "token":"eyJhbGciOi...",
  "newPassword":"123456"
}

↓

Backend password change করবে।
