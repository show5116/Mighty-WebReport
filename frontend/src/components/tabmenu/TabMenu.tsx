import * as S from './style.TabMenu';
import {useSelector} from "react-redux";
import {RootState} from "../../modules";
import Tab from "./Tab";
import {useEffect, useState} from "react";
import TabContent from "./TabContent";

const TabMenu = () => {
    const tabList = useSelector((state:RootState)=>state.tabMenuReducer);
    const [selectIndex,setSelectIndex] = useState(0);
    const [tabLength,setTabLength] = useState(0);

    useEffect(()=>{
        if(selectIndex === tabList.length){
            setSelectIndex(tabList.length-1);
        }else if(tabLength < tabList.length){
            setSelectIndex(tabList.length-1);
        }
        setTabLength(tabList.length);
    },[tabList,selectIndex,tabLength]);

    return (
        <S.Container>
            <div className='tabList'>
                {tabList.map((element,index)=> (
                    <Tab
                        key={`head ${element.label}`}
                        selected={selectIndex===index}
                        onClick={(event)=>setSelectIndex(index)}
                        label={element.label}
                        labelKor={element.labelKor}
                    />
                ))}
            </div>
            <div className='tabContent'>
                {tabList.map((element,index)=> (
                    <TabContent
                        key={`content ${element.label}`}
                        selected={selectIndex===index}
                        children={element.children}
                    />
                ))}
            </div>
        </S.Container>
    );
}

export default TabMenu;
