import { useState} from 'react';
import {useEffect } from 'react';
import axios from 'axios';
import { MoviePage } from 'types/movie';
import Pagination from 'components/Pagination';
import MovieCard from 'components/MovieCard';
import { BASE_URL } from 'utils/request';
// import './style.css';

function Listing() {

    const [pageNumber, setPageNumber] = useState(0)

    const [page, setPage] = useState<MoviePage>({
        content:[],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true,
    });

    useEffect( () => {

        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
        .then(response => {
            const data = response.data as MoviePage;
            setPage(data);
        })

    }, [pageNumber]);

    const handlePagechange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination page={page} onChange={handlePagechange} />

            <div className="container">
                <div className="row">
                    {page.content.map(movie  => (
                        <div key={movie.id} className="col-ms-6 col-lg-4 col-xl-3">
                            <MovieCard movie={movie} />
                        </div>
                    )
                    )}
                </div>
            </div>
        </>
    )
    
}

export default Listing;