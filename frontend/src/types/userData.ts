export interface IMemberTable {

}

export interface ICustomer {
    customer : string;
    customerName : string;
}

export interface IOperation {
    operation : string;
    description : string;
    customer: string;
}

export interface IDevice {
    deviceId : string;
    description : string;
    customer : string;
}

export interface IPlantTable {
    id : string;
    description? : string | null;
    numberOfShift : number;
    activePlant : string;
    daysPerWeek : number;
    hoursPerDay : number;
    regTime? : string | null;
    regUser? : string | null;
    shiftStartOne? : string | null;
    shiftStartTwo? : string | null;
    shiftStartThree? : string | null;
    shiftStartFour? : string | null;
}
