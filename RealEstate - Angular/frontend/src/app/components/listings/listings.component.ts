import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Listing } from 'src/app/models/listing';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.css']
})
export class ListingsComponent implements OnInit {
  listings: Listing[] = [];

  constructor(private listingService: ListingService, private router: Router) { }

  ngOnInit(): void {
    this.getListing();
  }

  private getListing(){
    this.listingService.getListingList().subscribe(data =>{
      this.listings = data;
    });
  }
}
