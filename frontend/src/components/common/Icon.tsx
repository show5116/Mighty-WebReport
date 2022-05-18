import { iconName, IconSet } from "../../assets/svg/constants";

interface IconProps {
    icon : iconName;
    size : number;
    color? : string;
    className? : string;
}

const Icon = ({ icon , size , color , className }: IconProps) => {
    return (
        <svg
            className={className}
            height={size}
            viewBox={IconSet[icon].viewBox}
            fill={color}
            xmlns="http://www.w3.org/2000/svg"
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
