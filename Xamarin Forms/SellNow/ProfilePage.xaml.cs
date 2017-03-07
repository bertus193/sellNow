using System.Collections.Generic;
using System;

using Xamarin.Forms;

namespace SellNow
{
	public partial class ProfilePage : ContentPage
	{

		public ProfilePage()
		{
			InitializeComponent();

		}
		async void OnModifyButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new ProfilePage());
		}

		async void OnNewAuctionButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new NewAuctionPage());
		}

		async void OnMyAuctionsButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new MyAuctionsPage());
		}
	}
}
