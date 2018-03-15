import { Component, OnInit } from '@angular/core';
import { StarService} from "../shared/star/star.service";
import {TmdbService} from "../shared/tmdb/tmdb.service";

@Component({
  selector: 'app-star-list',
  templateUrl: './star-list.component.html',
  styleUrls: ['./star-list.component.css']
})
export class StarListComponent implements OnInit {
  stars: Array<any>

  constructor(private starService: StarService, private tmdbService: TmdbService) { }

  ngOnInit() {
    this.starService.getAll().subscribe(data => {
      this.stars = data;
      for (const star of this.stars) {
        this.tmdbService.get(star.name).subscribe(url => star.tmdbUrl = url);
      }
    });
  }

}
