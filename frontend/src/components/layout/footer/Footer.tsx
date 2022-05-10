import * as S from './style.Footer';

const Footer = () => {
    return (
        <S.Container>
            <div className='footer-content'>
                <div className='footer-title'>
                    SAWNICS
                </div>
                <div className='footer-text'>
                    81.Hyeongoksandan-ro 93 beon-gil. Cheongbuk-eop. Pyeongtaek-si. 17812. South Korea<br/>
                    17812. 경기도 평택시 청북읍 현곡산단로 93번길 81. 주식회사쏘닉스<br/>
                    TEL: 82-31-686-8500 / FAX : 82-31-686-8501 <br />
                    © SAWNICS All Rights Reserved.
                </div>
            </div>
        </S.Container>
    );
}

export default Footer;
