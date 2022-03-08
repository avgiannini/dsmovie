import {ReactComponent as Image} from "assets/image.svg";
import './style.css';

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DsMovie</h1>
                    <a href="https://github.com/avgiannini">
                        <div className="dsmovie-contact">
                            <Image />
                            <p className="dsmovie-contact-link">Vignoto</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;