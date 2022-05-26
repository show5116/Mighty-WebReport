
export const getDate = (dateString:string) => {
    const year:string = dateString.substring(0,4);
    const month:string = dateString.substring(4,6);
    const day:string = dateString.substring(6,8);
    const hour:string = dateString.substring(8,10);
    const minute:string = dateString.substring(10,12);
    const second:string = dateString.substring(12,14);
    return new Date(Number(year),Number(month),Number(day),Number(hour),Number(minute),Number(second));
}

export const getMonthToMinute = (date:Date) => {
    return `${(date.getMonth()+1).toString().padStart(2,'0')}/${(date.getDate()).toString().padStart(2,'0')}
     ${date.getHours()}:${date.getMinutes()}`;
}
