					Imran sir code postman check



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
