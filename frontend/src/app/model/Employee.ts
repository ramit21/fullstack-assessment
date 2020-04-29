export class Employee {
    
    id : number;
	firstName : String;
	lastName : String;
	gender : String;
    dateOfJoining: String;
    dept: String;

    constructor(id : number, firstName : String, lastName : String,
            gender : String, dateOfJoining : String, dept : String){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
        this.dept = dept;
    }

}