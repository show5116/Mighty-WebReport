export type CallbackFunction = () => void;

export interface Option {
    text: string;
    value?: string;
}

export interface TableHeader {
    text: string;
    width: string;
}

export interface ISearchBox {
    text: string;
    id: string;
    condition?: string;
}

export interface IAlert {
    show: boolean;
    header?: string;
    bold?: string;
    text?: string;
    callback?: CallbackFunction;
}

