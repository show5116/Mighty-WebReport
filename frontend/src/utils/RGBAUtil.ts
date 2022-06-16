const RGBAString : string[] = [
    'rgba(255, 51, 153, 0.5)',
    'rgba(51, 153, 255, 0.5)',
    'rgba(153, 255, 51, 0.5)',
    'rgba(204, 0, 255, 0.5)',
    'rgba(255, 153, 000, 0.5)',
    'rgba(255, 51, 51, 0.5)',
    'rgba(255, 255, 102, 0.5)',
    'rgba(102, 255, 255, 0.5)',
    'rgba(204, 204, 204, 0.5)',
    'rgba(0, 0, 255, 0.5)',
    'rgba(0, 255, 0, 0.5)',
    'rgba(255, 0, 0, 0.5)',
    'rgba(0, 0, 0, 0.5)',
];

export const getRGBA = (index : number) => {
    return RGBAString[index % RGBAString.length];
};


