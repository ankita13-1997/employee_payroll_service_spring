package com.projectBL.employeepayroll.controller;

import com.projectBL.employeepayroll.dtoModel.EditPayrollDto;
import com.projectBL.employeepayroll.dtoModel.EmployeePayrollDto;
import com.projectBL.employeepayroll.dtoModel.ResponseDto;
import com.projectBL.employeepayroll.services.IPayrollServices;
import com.projectBL.employeepayroll.services.PayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    IPayrollServices payrollServices = new PayrollServices();



    @GetMapping("/gethello")
    public String getHello(){
        return "Hello World";

    }



    /* curl -X POST -H "Content-Type:application/json"  http://localhost:8080/payroll-context/employeepayrollservice/add -d '{"name": "Ankita",
    "salary": "100000",
    "gender": "Female",
    "profilePic": "yo",
    "department": [
      "Devops"
    ],
    "startDate": "23.09.90",
    "notes": "hello this is me"}'*/

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> adduser(@RequestBody EmployeePayrollDto employee){
        EmployeePayrollDto employeePayrollDto = payrollServices.addUsers(employee);

        return new ResponseEntity<ResponseDto>(new ResponseDto("Employee added Successfully",
                                                               "200",employeePayrollDto),
                                                                HttpStatus.CREATED);


    }







 /*curl -X DELETE --header 'Accept: application/json'
 'http://localhost:8080/payroll-context/employeepayrollservice/delete/59ba6c4d-2bc0-4aaa-a6f7-f658b47d2be6'
  */
@DeleteMapping("/delete/{id}")
public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id") UUID employeeId){
EmployeePayrollDto employeePayrollDto =payrollServices.deleteUser(employeeId);
return new ResponseEntity<ResponseDto>(new ResponseDto("Employee deleted successfully",
                                                       "200",employeePayrollDto),
                                                        HttpStatus.CREATED);

}





/* curl -X GET --header 'Accept: application/json'
'http://localhost:8080/payroll-context/employeepayrollservice/
 queryfind?employeeId=fc3cf8a4-f41b-4e71-addf-7c1f7b0a334c'
 */
@GetMapping("/queryfind")
public ResponseEntity<ResponseDto> findUserById(@RequestParam(value = "employeeId") UUID employeeId){

     EmployeePayrollDto employeePayrollDto =payrollServices.findUserById(employeeId);
    return new ResponseEntity<ResponseDto>(new ResponseDto("emplyee you finding are"
                                                           ,"200",employeePayrollDto),
                                                             HttpStatus.OK);

}




/*curl -X GET --header 'Accept: application/json'
'http://localhost:8080/payroll-context/employeepayrollservice/get'*/
@GetMapping("/get")
public ResponseEntity<List<EmployeePayrollDto>> findAllUser(){
return ResponseEntity.status(HttpStatus.OK).body(payrollServices.findAllUsers());
}





/* curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
   "department": [
     "volvo"
   ],
   "employeeId": "682ed12c-678a-46c8-92c0-3e33ef38dff7",
   "gender": "Female",
   "name": "Ankita Parhi",
   "notes": "gradually updated",
   "profilePic": "mx.jpg",
   "salary": "98000",
   "startDate": "29-09-18"
 }' 'http://localhost:8080/payroll-context/employeepayrollservice/update'
*/
@PutMapping("/update")
public ResponseEntity<ResponseDto> updateAnEmployee(@RequestBody EditPayrollDto user){
    EmployeePayrollDto employeePayrollDto = payrollServices.updateUserDetails(user);
    return new ResponseEntity<ResponseDto>(new ResponseDto("Employee detailes updated successfully for " ,
                                                       "200",employeePayrollDto),
                                                        HttpStatus.CREATED);

  }

}
