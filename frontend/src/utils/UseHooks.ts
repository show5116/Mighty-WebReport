import {useEffect, useState} from "react";

const useTitle = (initialTitle : string) => {
    const [title, setTitle] = useState(initialTitle);

    const updateTitle = () => {
        const defaultTitle = "SAWNICS - 웹리포트";
        const htmlTitle = document.querySelector("title");
        if(htmlTitle !=null){
            htmlTitle.innerText = defaultTitle + title;
        }
    };
    useEffect(updateTitle, [title]);

    return setTitle;
}

export default useTitle;
