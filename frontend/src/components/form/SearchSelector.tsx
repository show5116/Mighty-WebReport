import * as S from "./style.SearchSelector";
import {ICheckBox} from "../../types/type";
import React, {Dispatch, SetStateAction, useEffect, useState} from "react";
import Icon from "../common/Icon";

interface IProps {
    title : string;
    list : ICheckBox[];
    selected : Set<String>;
    selector : Dispatch<SetStateAction<Set<String>>>;
}

const SearchSelector = ({ title , list , selected, selector } : IProps) => {

    const [search,setSearch] = useState("");
    const [searched,setSearched] = useState<ICheckBox[]>([]);
    const [focus,setFocus] = useState(false);
    const [searchBoxFocusItem,setSearchBoxFocusItem] = useState(-1);
    const [resultBoxFocusItem,setResultBoxFocusItem] = useState(-1);

    useEffect(()=>{
        setSearched(list.filter(isSearched));
    },[search])

    const onChange = (event : React.ChangeEvent<HTMLInputElement>) => {
        setSearch(event.target.value);
    }

    const isSearched = (element : ICheckBox) => {
        return !selected.has(element.text) && element.text.toUpperCase().includes(search.toUpperCase());
    }

    const textEffect = (text : string ) => {
        if(search===""){
            return text;
        }
        const indexes = text.toUpperCase().matchAll(new RegExp(search.toUpperCase(),'gi'));
        let result = text;
        let count : number = 0;
        while (true){
            const {value,done}  = indexes.next();
            if(done) break;
            result = [
                // @ts-ignore
                result.slice(0,value.index+count*13),
                "<bold>",
                // @ts-ignore
                result.slice(value.index+count*13,value.index+search.length+count*13),
                "</bold>",
                // @ts-ignore
                result.slice(value.index+search.length+count*13)].join('');
            count++;
        }
        return result;
    }

    const onSelect = (event : React.MouseEvent<HTMLLIElement>) => {
        if(event.currentTarget instanceof Element){
            selector((prev) => {
                // @ts-ignore
                return new Set(prev.add(event.currentTarget.textContent))
            });
            setSearchBoxFocusItem(-1);
            setSearched(list.filter(isSearched));
        }
    }

    const onDelete = (event : React.MouseEvent<HTMLLIElement>) => {
        setResultBoxFocusItem(-1);
        if(event.currentTarget instanceof Element
            && event.currentTarget.textContent!==null){
            const item : string = event.currentTarget.textContent;
            selector((prev) => {
                prev.delete(item);
                return new Set(prev)
            });
            setSearched(list.filter(isSearched));
        }
    }

    const onFocus = () => {
        if(searched.length===0){
            setFocus(false);
        }else{
            setFocus(true);
        }
    }

    const onBlur = (event : React.FocusEvent<HTMLInputElement>) => {
        setFocus(false);
    }

    const onKeyDown = (event : React.KeyboardEvent<HTMLInputElement>) => {
        if(searched.length===0 || event.key === "Escape"){
            setFocus(false);
        }else if(event.key === "ArrowDown"){
            setSearchBoxFocusItem((prev)=>{
                if(prev === searched.length-1) {
                    return 0;
                }
                return prev + 1;
            });
            setFocus(true);
        }else if(event.key === "ArrowUp"){
            setSearchBoxFocusItem((prev)=>{
                if(prev <= 0) {
                    return searched.length-1;
                }
                return prev-1;
            });
            setFocus(true);
        }else if(event.key === "Enter"){
            selector((prev) => {
                return new Set(prev.add(searched[searchBoxFocusItem].text))
            });
            setSearched(list.filter(isSearched));
            setSearchBoxFocusItem(-1);
            setFocus(false);
        } else{
            setSearchBoxFocusItem(-1);
            setFocus(true);
        }
    }

    const SearchIcon = () => (<Icon icon="search" size={15} />)

    useEffect(()=>{
        if(searched.length===0){
            setFocus(false);
        }
    },[searched])

    return (
        <S.Container>
            <div className='header'>
                {title}
            </div>
            <div className='search-box'>
                <SearchIcon />
                <input
                    type="text"
                    value={search}
                    placeholder="Search..."
                    onChange={onChange}
                    onFocus={onFocus}
                    onBlur={onBlur}
                    onKeyDown={onKeyDown}
                    className={focus ? "focus" : undefined}
                />
                {focus && (
                <ul>
                    {searched.map((element,index)=>
                        (
                            <li
                                id={element.id}
                                key={element.id}
                                dangerouslySetInnerHTML={{__html: textEffect(element.text)}}
                                onMouseDown={onSelect}
                                className={index===searchBoxFocusItem ? "focus-item" : undefined}
                            >
                            </li>
                        )
                    )}
                </ul>)}
            </div>
            <ul className='selected-list'>
                {Array.from(selected.values()).map((element:any,index)=>(
                    <li
                        key={element}
                        onDoubleClick={onDelete}
                        onClick={()=>setResultBoxFocusItem(index)}
                        className={resultBoxFocusItem===index ? "focus-item" : undefined}
                    >
                        {element}
                    </li>
                ))}
            </ul>
        </S.Container>
    );
};

export default SearchSelector;
