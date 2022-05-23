export type CallbackFunction = () => void;

export interface Option {
    text: string;
    value?: string;
};

export interface ISearchBox {
    text: string;
    id: string;
}

export interface IAlert {
    show: boolean;
    header?: string;
    bold?: string;
    text?: string;
    callback?: CallbackFunction;
}

