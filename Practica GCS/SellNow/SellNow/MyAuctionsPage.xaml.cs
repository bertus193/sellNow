using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class MyAuctionsPage : ContentPage
	{
		public MyAuctionsPage()
		{
			InitializeComponent();
			var navigateButton = new Button { Text = "producto1" };
			navigateButton.Clicked += OnNavigateButtonClicked;
		}

		async void OnNavigateButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new Producto());
		}
	}
}
