import { iconName, IconSet } from "../../assets/svg/constants";
import {CallbackFunction} from "../../types/type";

interface IconProps {
    icon : iconName;
    size : number;
    color? : string;
    className? : string;
    onClick? : CallbackFunction;
}

const Icon = ({ icon , size , color , className , onClick }: IconProps) => {
    return (
        <svg
            className={className}
            height={size}
            viewBox={IconSet[icon].viewBox}
            fill={color}
            xmlns="http://www.w3.org/2000/svg"
            onClick={onClick}
        >
            <path
                fill={IconSet[icon].fill}
                fillRule={IconSet[icon].fillRule}
                stroke={IconSet[icon].stroke}
                strokeLinecap={IconSet[icon].strokeLinecap}
                strokeLinejoin={IconSet[icon].strokeLinejoin}
                strokeWidth={IconSet[icon].strokeWidth}
                d={IconSet[icon].path}
                transform={IconSet[icon].transform}
            />
        </svg>
    );
};

export default Icon;
