
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using SellNowMenu;

namespace SellNow
{
	[Activity(Label = "verProducto", Theme = "@android:style/Theme.Holo.NoActionBar")]
	public class verProducto : Activity
	{
		protected override void OnCreate(Bundle savedInstanceState)
		{
			base.OnCreate(savedInstanceState);

			SetContentView(Resource.Layout.Producto);

			createMenu();
		}

		public void createMenu()
		{
			var menu = FindViewById<SellNowContainer>(Resource.Id.SellNowContainer);
			var menuButton = FindViewById(Resource.Id.MenuButtonProducto);
			menuButton.Click += (sender, e) =>
			{
				menu.AnimatedOpened = !menu.AnimatedOpened;
			};
		}
	}
}
