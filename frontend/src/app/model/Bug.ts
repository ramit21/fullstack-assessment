export class Employee {
    
    id : number;
	firstName : string;
	lastName : string;
	gender : string;
    dateOfJoining: string;
    dept: string;

    constructor(id : number, firstName : string, lastName : string,
            gender : string, dateOfJoining : string, dept : string){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
        this.dept = dept;
    }

}