import Pagination from 'componentes/Pagination';
import MovieCard from 'componentes/MovieCard';
import { useState, userEffect } from 'react';
import axios from 'axios';
import { BASE_URL } from 'utils/request';
import MoviePage from 'types/movie';

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    userEffect( () => {
        
        axios.get('${BASE_URL}/movie?size=12&page=0')
        .then(response => {
            const data = response.data as MoviePage;
            setPageNumber(data.number)
        })

    }, [])

    

    return (
        <>
            <Pagination />
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    )
    
}

export default Listing;