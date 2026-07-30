
Customexception Use :

Controller
   │
   │ Exception হলে
   ▼
GlobalExceptionHandler
   │
   ▼
Common Error Response




@RestControllerAdvice + @ExceptionHandler Spring-এর কাছে একটি Global Exception Routing System-এর মতো কাজ করে।

তুমি Controller থেকে GlobalExceptionHandler call করো না। বরং Controller → Service থেকে Exception বের হলে Spring নিজে সেই Exception-এর Type দেখে matching @ExceptionHandler Method খুঁজে সেখানে পাঠিয়ে দেয়।

এই কারণেই তোমার getById()-তে try-catch ছাড়াই EmployeeNotFoundException সুন্দরভাবে 404 Not Found Response হিসেবে Postman-এ চলে আসে।




Note/Advice :

সাধারণ console output	❌ System.out.println() নয়
Application event	✅ log.info()
Expected warning	✅ log.warn()
Unexpected exception	✅ log.error()
Debug information	✅ log.debug()
Exception handle করতে হবে	✅ try-catch
শুধু exception ধরে আবার throw করবে	❌ অপ্রয়োজনীয় try-catch এড়াও
Global API exception	✅ @RestControllerAdvice