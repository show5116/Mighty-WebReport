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

export interface ILotStatus {
    operation?: string| null;
    lotNumber?: string| null;
    mainLot?: string | null;
    qtyOne?: number| null;
    qtyUnitOne?: string| null;
    qtyTwo?: number | null;
    qtyUnitTwo?: string | null;
    device?: string| null;
    customer?: string | null;
    inHold?: string| null;
    holdNote?: string | null;
    inRework?: string| null;
    processFlag?: string| null;
    deviceVer?: string | null;
    deviceAttribute?: string | null;
    shipAttribute?: string | null;
    route?: string| null;
    enterOperTime?: string| null;
    equipmentId?: string | null;
    isOperation?: boolean;
    colSpan? : number;
}
