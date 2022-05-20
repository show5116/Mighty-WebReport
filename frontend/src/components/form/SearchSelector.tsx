import * as S from "./style.SearchSelector";
import {ISearchBox} from "../../types/type";
import React, {useEffect, useState} from "react";
import Icon from "../common/Icon";
import {useSelector} from "react-redux";
import {RootState} from "../../modules";

interface IProps {
    title : string;
    list : ISearchBox[];
    selected : ISearchBox[];
    selector :  React.Dispatch<React.SetStateAction<ISearchBox[]>>;
}

const SearchSelector = ({ title , list , selected, selector } : IProps) => {

    const [search,setSearch] = useState("");
    const [searched,setSearched] = useState<ISearchBox[]>([]);
    const [focus,setFocus] = useState(false);
    const [searchBoxFocusItem,setSearchBoxFocusItem] = useState(-1);
    const [resultBoxFocusItem,setResultBoxFocusItem] = useState(-1);
    const langState = useSelector((state:RootState) => state.menuReducer );

    const onChange = (event : React.ChangeEvent<HTMLInputElement>) => {
        setSearch(event.target.value);
    }

    const onSelect = (event : React.MouseEvent<HTMLLIElement>) => {
        if(event.currentTarget instanceof Element
            && event.currentTarget.textContent !== null ){
            select(event.currentTarget.id,
                event.currentTarget.textContent);
        }
    }

    const onDelete = (event : React.MouseEvent<HTMLLIElement>) => {
        setResultBoxFocusItem(-1);
        if(event.currentTarget instanceof Element){
            selector(
                selected.filter(value => value.id !== event.currentTarget.id)
            );
            setSearched(list.filter(isSearched));
        }
    }

    const onFocus = () => {
        setSearched(list.filter(isSearched));
        if(list.filter(isSearched).length !== 0 ){
            setFocus(true);
        }
    }

    const onBlur = (event : React.FocusEvent<HTMLInputElement>) => {
        setFocus(false);
    }

    const deleteInput = () => {
        setSearch("");
    }

    const onKeyDown = (event : React.KeyboardEvent<HTMLInputElement>) => {
        if(searched.length===0 || event.key === "Escape"){
            setFocus(false);
        }else if(event.key === "ArrowDown"){
            event.preventDefault();
            setSearchBoxFocusItem((prev)=>{
                if(prev >= searched.length-1) {
                    return 0;
                }
                return prev + 1;
            });
            setFocus(true);
        }else if(event.key === "ArrowUp"){
            event.preventDefault();
            setSearchBoxFocusItem((prev)=>{
                if(prev <= 0) {
                    return searched.length-1;
                }
                return prev-1;
            });
            setFocus(true);
        }else if(event.key === "Enter"){
            if( searchBoxFocusItem === -1) {
                select(searched[0].id,
                    searched[0].text);
            }else{
                select(searched[searchBoxFocusItem].id,
                    searched[searchBoxFocusItem].text);
            }
        } else{
            setSearchBoxFocusItem(-1);
            setFocus(true);
        }
    }

    const isSearched = (element : ISearchBox) => {
        return !selected.find((item) => item.id === element.id) &&
            element.text.toUpperCase().includes(search.toUpperCase());
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

    const select = ( id : string , text : string) => {
        selector((prev) => {
            return [...prev,
                {
                    id : id,
                    text : text,
                }]
        });
        setSearched(list.filter(isSearched));
        setSearchBoxFocusItem(-1);
        setFocus(false);
    }



    useEffect(()=>{
        setSearched(list.filter(isSearched));
    },[list,search,selected])

    useEffect(()=>{
        if(searched.length===0){
            setFocus(false);
        }
    },[searched])

    const SearchIcon = () => (<Icon icon="search" size={15} className='search'/>)
    const XIcon = () => (<Icon icon="x" size={10} className='delete-input' onClick={deleteInput}/>);

    return (
        <S.Container>
            <div className='header'>
                {title}
            </div>
            <div className='search-box'>
                <SearchIcon />
                {search !== "" && (<XIcon />)}
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
                                key={element.text}
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
                {selected.map((element,index)=>(
                    <li
                        id={element.id}
                        key={element.id}
                        onDoubleClick={onDelete}
                        onClick={()=>setResultBoxFocusItem(index)}
                        className={resultBoxFocusItem===index ? "focus-item" : undefined}
                    >
                        {element.text}
                    </li>
                ))}
                {selected.length !== 0 && (
                    <li>
                        {langState.isKor ? "전체삭제" : "Delete All"}
                    </li>
                )}
            </ul>
        </S.Container>
    );
};

export default SearchSelector;
