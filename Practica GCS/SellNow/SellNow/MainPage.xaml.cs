using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class MainPage : ContentPage
	{
		public MainPage()
		{
			InitializeComponent();

			var navigateButton = new Button { Text = "producto1" };
			navigateButton.Clicked += OnNavigateButtonClicked;
		}

		async void OnNavigateButtonClicked(object sender, EventArgs e)
		{
			//await Navigation.PopAsync();
			await Navigation.PushAsync(new Producto());
			//Detail = new NavigationPage((Page)Activator.CreateInstance(typeof(ProfilePage)));
		}
	}
}
